const onClick = function(event) {
    event.preventDefault();

    const pirateNameEle = document.getElementById('pirate-name');
    const pirateRoleEle = document.getElementById('pirate-role');

    // Truthy and falsy values in javascript ''
    if (pirateNameEle.value) {
        const pirateObj = {
            name: pirateNameEle.value,
            role_name: pirateRoleEle.value
        }
    
        console.log(pirateObj);
    
        const xhr = new XMLHttpRequest();
    
        xhr.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 201) {
                console.log("Pirate added!");
                window.location.href = '/PirateServer/pirate-list';
            } else if (this.readyState == 4) {
                alert('Encountered an error when attempting to add a pirate!');
            }
        }
    
        xhr.open("POST", "http://localhost:8080/PirateServer/pirate");
        xhr.send(JSON.stringify(pirateObj));
    
    } else {
        alert('Please enter a nonblank value for pirate name!');
    }
    
}

const submit = document.getElementById('pirate-submit');

// Event listener
submit.addEventListener('click', onClick)