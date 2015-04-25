function taskViewOptionChange()
{
	alert('Task Filtered.');
}
function validateForm() {
    var x = document.forms["taskManagementform"]["task"].value;
    if (x == null || x == "") {
        alert("Please enter task.");
        return false;
    }
}

document.addEventListener("DOMContentLoaded", function(){
	document.forms["contact-form"].addEventListener("submit",postData);
});

