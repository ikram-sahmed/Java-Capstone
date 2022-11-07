const cookieArr = document.cookie.split("=");
const userId = cookieArr[1];

const registerButton = document.getElementById("Register");
const loginButton = document.getElementById("Login");
const container = document.getElementById("container");

registerButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

loginButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});

const submitRegister = document.getElementById("RegisterForm");
const submitLogin = document.getElementById ("LoginForm");

const registerUsername = document.getElementById("register-username")
const registerPassword = document.getElementById("register-password")
const registerEmail = document.getElementById ("email")
const loginUsername = document.getElementById("username");
const loginPassword = document.getElementById("password");


const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'


const handleSubmitRegister = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        username: registerUsername.value,
        password: registerPassword.value,
        email: registerEmail.value
    }

    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0])
    }
}

const handleSubmitLogin = async (e) => {
    e.preventDefault()

    let bodyObj = {
        username: loginUsername.value,
        password: loginPassword.value
    }

    const response = await fetch(`${baseUrl}/login`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        document.cookie = `userId=${responseArr[1]}`
        window.location.replace("http://localhost:8080/sleep.html")
    }

}
submitRegister.addEventListener("click", handleSubmitRegister);
submitLogin.addEventListener("click", handleSubmitLogin);


//document.getElementById('Register').addEventListener('click', function(){
//    container.classList.add("right-panel-active");
//    handleButtonRegister("Register");
//});

