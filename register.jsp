<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #f0f2f5;
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    form {
        background: white;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        width: 300px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"],
    select {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="radio"] {
        margin-right: 5px;
    }

    .radio-group {
        margin-bottom: 15px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

</style>
</head>
<body>
    <form action="regForm" method="post">
        <label>Name:</label>
        <input type="text" name="name1" />

        <label>Email:</label>
        <input type="email" name="email1" />

        <label>Password:</label>
        <input type="password" name="pass1" />

        <label>Gender:</label>
        <div class="radio-group">
            <input type="radio" name="gender1" value="Male" /> Male
            <input type="radio" name="gender1" value="Female" /> Female
        </div>

        <label>City:</label>
        <select name="city1">
            <option>Select City</option>
            <option>Pune</option>
            <option>Mumbai</option>
            <option>Delhi</option>
            <option>Patna</option>
        </select>

        <input type="submit" value="Register" />
    </form>
</body>
</html>
