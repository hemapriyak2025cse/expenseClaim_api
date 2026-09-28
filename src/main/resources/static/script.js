const loginForm = document.getElementById("loginForm");
const loginMessage = document.getElementById("loginMessage");

loginForm.addEventListener("submit", function (event) {

    event.preventDefault();

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const role = document.getElementById("role").value;

    if (role === "") {
        loginMessage.textContent = "Please select a role.";
        return;
    }

    if (email === "" || password === "") {
        loginMessage.textContent = "Please enter email and password.";
        return;
    }

    if (role === "employee") {
        loginMessage.textContent = "Employee login selected.";
    }

    if (role === "manager") {
        loginMessage.textContent = "Manager login selected.";
    }
});