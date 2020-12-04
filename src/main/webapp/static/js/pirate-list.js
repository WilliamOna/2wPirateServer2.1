const placePirate = function(pirateId, pirateName, roleId, roleName) {
    const tableBody = document.getElementById('pirate-table-data');

    const entry = document.createElement('tr');

    entry.innerHTML = 
    `<td>${pirateId}</td>
    <td>${pirateName}</td>
    <td>${roleId}</td>
    <td>${roleName}</td>`;

    tableBody.appendChild(entry);
}

const getPirates = function() {
    const xhr = new XMLHttpRequest();

    // There are essentially 5 different ready states
    // 0: Unsent
    // 1: Opened
    // 2: Headers_received
    // 3: Loading
    // 4: Done
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            const data = JSON.parse(xhr.responseText);

            for (let i = 0; i < data.length; i++) {
                placePirate(data[i].id, data[i].name, data[i].role.id, data[i].role.role);
            }

            console.log("Pirate data received");
        }
    }

    xhr.open('GET', 'http://localhost:8080/PirateServer/pirate');

    xhr.send();
}

getPirates();
console.log("Hi there!");