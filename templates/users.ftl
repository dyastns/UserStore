<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <style>
        h2 {
            text-align: center;
        }
        table {
            margin: auto;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 5px;
            text-align: left;
        }
        tr:nth-child(even) {
            background-color: #eee;
        }
        tr:nth-child(odd) {
            background-color: #fff;
        }
    </style>
</head>
<body>
<h2>Users</h2>
<table style="width:85%">
    <tr>
        <th>Id</th>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Salary</th>
        <th>Date of birth</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td style="text-align:right"><#if (user.salary)??>${user.salary?string(",##0.00")}</#if></td>
            <td style="text-align:right">
                <#if (user.dateOfBirth)??>${user.dateOfBirth}</#if>
            </td>
        </tr>
    </#list>
</table>

</body>
</html>