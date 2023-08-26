<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Редактировать данные автомобиля</title>
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
<h3>Редактировать данные автомобиля</h3>
<form action="/ServiceRatesPage/update/${car.id}" method="post">
    <input type="hidden" name="_method" value="PUT">
    <label for="name">Название:</label><br>
    <input type="text" id="name" name="name" value="${car.name}"><br>
    <label for="brand">Марка:</label><br>
    <input type="text" id="brand" name="brand" value="${car.brand}"><br>
    <label for="country">Страна:</label><br>
    <input type="text" id="country" name="country" value="${car.country}"><br>
    <label for="productionYear">Год производства:</label><br>
    <input type="text" id="productionYear" name="productionYear" value="${car.productionYear}"><br>
    <label for="engineCapacity">Объем двигателя:</label><br>
    <input type="text" id="engineCapacity" name="engineCapacity" value="${car.engineCapacity}"><br>
    <label for="price">Цена:</label><br>
    <input type="text" id="price" name="price" value="${car.price}"><br>
    <label for="isSold">Продано:</label><br>
    <select id="isSold" name="isSold">
        <option value="Да"<#if car.isSold == "Да"> selected</#if>>Да</option>
        <option value="Нет"<#if car.isSold == "Нет"> selected</#if>>Нет</option>
    </select><br>
    <input type="submit" value="Сохранить">
</form>
<form action="/ServiceRatesPage">
    <input type="submit" value="Отменить">
</form>
</body>
</html>