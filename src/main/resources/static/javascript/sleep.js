const timeOfSleep = document.getElementById("sleepTime");
const timeOfWake = document.getElementById("wakeUpTime");
const sleepDuration = document.getElementById("sleepDuration");
const submit = document.getElementById("submitSleep");


const headers = {
    'Content-Type':'application/json'
}
const baseUrl1 = "http://localhost:8080/api/v1/sleep"



const addNewSleepEntry = async (e) => {
    e.preventDefault()

    let bodyObj = {
        sleepTime :timeOfSleep.value,
        wakeUpTime: timeOfWake.value,
        hoursOfSleep: sleepDuration.value,
    }

    const response = await fetch(`${baseUrl1}/user/${userId}`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
       .catch(err => console.error(err.message))

    if (response.status === 200){
        window.location.reload();
        }
};
let userId = (document.cookie.split('=')[1]);
userId = parseInt(userId);

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
    window.location.replace("http://localhost:8080/home.html");
}


submit.addEventListener("click", addNewSleepEntry);
