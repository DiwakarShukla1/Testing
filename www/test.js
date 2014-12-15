var test = {
    createEvent: function(title, location, notes, startDate, endDate, successCallback, errorCallback) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'Test', // mapped to our native Java class called "Calendar"
            'start',
            []
        ); 
     }
}

module.exports = test;