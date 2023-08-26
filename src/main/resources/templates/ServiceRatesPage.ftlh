<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:nth-child(odd) {
                    background-color: #f2f2f2;
                }
        th {
            background-color: #4CAF50;
            color: white;
        }
        input[type=submit] {
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            input[type=submit]:hover {
                background-color: #45a049;
            }
    </style>
</head>
<body>
<h3>Добавить новый автомобиль</h3>
<table>
    <colgroup>
        <col span="1" style="background:Khaki">
        <col span="6" style="background-color:LightCyan">
    </colgroup>
<form action="ServiceRatesPage/create" method="post">
    <tr>
        <th>Id</th>
        <th>Название</th>
        <th>Марка</th>
        <th>Страна</th>
        <th>Год производства</th>
        <th>Объем двигателя</th>
        <th>Цена</th>
        <th>Действие</th>
    </tr>
    <tr>
        <td>Новый ID</td>
        <td><input type="text", name="name"><br><br></td>
        <td><input type="text", name="brand"><br><br></td>
        <td><input type="text", name="country"><br><br></td>
        <td><input type="text", name="productionYear"><br><br></td>
        <td><input type="text", name="engineCapacity"><br><br></td>
        <td><input type="text", name="price"><br><br></td>
        <td><input type="hidden", name="isSold" value="Нет"></td>
        <td><input type="submit" value="Добавить автомобиль"/></td>

    </tr>

</form>

</table>

<h3>Список автомобилей:</h3>

<table>

    <colgroup>

        <col span="1" style="background:Khaki">

        <col span="6" style="background-color:LightCyan">

    </colgroup>

    <tr>

<th>Id</th>

<th>Название</th>

<th>Марка</th>

<th>Страна</th>

<th>Год производства</th>

<th>Объем двигателя</th>

<th>Цена</th>

<th>Продано</th>

<th>Действие</th>


    </tr>


<#list Rates as Rate>
    <tr>
        <td>${Rate.id}</td>
        <td>${Rate.name}</td>
        <td>${Rate.brand}</td>
        <td>${Rate.country}</td>
        <td>${Rate.productionYear}</td>
        <td>${Rate.engineCapacity}</td>
        <td>${Rate.price}</td>
        <td>${Rate.isSold}</td>
        <td>
            <form action="/ServiceRatesPage/delete/${Rate.id}" method="post">
                <input type="submit" value="Удалить автомобиль"/>
            </form>
            <form action="/ServiceRatesPage/sell/${Rate.id}" method="post">
                <input type="submit" value="<#if Rate.isSold == 'Да'>Отменить продажу<#else>Продать автомобиль</#if>"/>
            </form>
            <form action="/ServiceRatesPage/edit/${Rate.id}" method="get">
                <input type="submit" value="Редактировать данные"/>
            </form>
        </td>
    </tr>
</#list>


</table>



</body>



</html>