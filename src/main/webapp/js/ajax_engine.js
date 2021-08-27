/*
AJAX-Engine
Verwendet die fetch-API

29.01.2020, Pius Senn
*/

/**
 *    XMLHttpRequest absetzen und verarbeiten
 *
 *    @param    source                URL from which the HTML snippet should be requested
 *    @param    target                ID of the element in which the HTML snippet is to be inserted
 *    @param    errorMessage        Error message for the output in the console
 */
function requestData(source, target, errorMessage = 'Error') {
    fetch(source)
        .then(function (response) {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error(errorMessage);
            }
        })
        .then(function (data) {
            document.getElementById(target).innerHTML = data;
        })
        .catch(function (error) {
            console.log(error);
        });
}
