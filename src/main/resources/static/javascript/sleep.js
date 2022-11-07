const timeOfSleep = document.getElementById("sleepTime");
const timeOfWake = document.getElementById("wakeUpTime");
const sleepDuration = document.getElementById("sleep-Duration");
const submit = document.getElementById("submitSleep");


const headers = {
    'Content-Type':'application/json'
}
const baseUrl1 = "http://localhost:8080/api/v1/sleep"

//let userId = (document.cookie.split('=')[1]);
//userId = parseInt(userId);

//function handleLogout(){


const addNewSleepEntry = async (e) => {
    e.preventDefault()
    console.log("hello")
    let bodyObj = {
        sleepTime :timeOfSleep.value,
        wakeUpTime: timeOfWake.value,
        hoursOfSleep: sleepDuration
    }

    const response = await fetch(`${baseUrl1}/user/${userId}`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    const responseArr = await response.json()

    console.log(responseArr);
    if (response.status === 200){
        window.location.reload();
        }
};


submit.addEventListener("click", addNewSleepEntry);