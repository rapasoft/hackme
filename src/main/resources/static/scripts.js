function populateSearchResults(data) {
    $('#userSearchResults').html('<table class="table">' +
        '<thead><tr>' +
        '<th>Name</th>' +
        '<th>Age</th>' +
        '<th>Department</th>' +
        '<th>EmploymentType</th>' +
        '<th>Start date</th>' +
        '<th>End date</th>' +
        '</tr></thead>' +
        '<tbody>' +
        data.map(user => ('<tr>' +
            `<td>${user.name}</td>` +
            `<td>${user.age}</td>` +
            `<td>${user.department}</td>` +
            `<td>${user.employmentType}</td>` +
            `<td>${user.startDate}</td>` +
            `<td>${user.endDate}</td>` +
            '</tr>')).join('') +
        '</tbody>' +
        '</table>')
}

function searchByName(name) {
    window.fetch("/api/person/" + name)
        .then(result => result.json())
        .then(populateSearchResults)
}