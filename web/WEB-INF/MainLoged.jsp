<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Виталик
  Date: 26.05.2016
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>TaskManager</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="my_style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
</head>
<body>
<script>

    $(function(){
        var navMain = $(".navbar-collapse");
        navMain.on("click", "a", null, function () {
            navMain.collapse('hide');
        });
    });

</script>
<div class="modal fade" id="Window1" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">x</button>
                <h4>Покорение космоса</h4>
                <a href="#" style="text-decoration:underline;margin:10px;margin-left:0px;" data-toggle="modal" data-target="#NewSubtask">Добавление подзадачи</a>
                <a href="#" style="text-decoration:underline;margin:10px;margin-left:0px;" data-toggle="modal" data-target="#NewComment">Добавление комментария</a>
            </div>
            <div class="modal-body" style="padding:15px;">
                <h5>15.01.16-16.02.16</h5>
                <h4>Описание</h4>
                <h5 style="padding-bottom:5px; border-bottom: 1px solid #e5e5e5;">big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text big text </h5>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th >Подзадача</th>
                        <th >Название</th>
                        <th >Deadline</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>Пилит</td>
                        <td>15.01.16</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Что-то делает</td>

                        <td>16.01.16</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Кодит</td>
                        <td>17.01.16</td>
                    </tr>
                    </tbody>
                </table>

                <h4>Коментарии</h4>
                <h5 style="padding-bottom:5px; border-bottom: 1px solid #e5e5e5;">бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла-бла</h5>
                <h5 style="padding-bottom:5px; border-bottom: 1px solid #e5e5e5;">Комментарий 2</h5>
                <h5 style="padding-bottom:5px; border-bottom: 1px solid #e5e5e5;">Комментарий 3</h5>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="RegModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">x</button>
                <h4 class="modal-title" id="myModalLabel">Registration</h4>
            </div>
            <div class="modal-body">
                <form action="/Registration" method="POST">
                    <div class="form-group">
                        <input name='RegName' type="text" placeholder="Name" class="form-control">
                    </div>
                    <div class="form-group">
                        <input name='RegMail' type="text" placeholder="Email" class="form-control">
                    </div>
                    <div class="form-group">
                        <input name='RegPass' type="password" placeholder="Password" class="form-control">
                    </div>
                    <div class="form-group">
                        <input name='RegDoblePass' type="password" placeholder="Repeat password" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-success">Submit</button>

                </form>
            </div>

        </div>
    </div>
</div>
<div class="modal fade" id="NewComment" tabindex="0" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">x</button>
                <h4 class="modal-title" id="myModalLabel">New comment</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input type="text" placeholder="Comment" class="form-control">
                </div>

                <button type="submit" class="btn btn-success" onclick='addList()'>Add comment</button>

            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="SignModal" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">x</button>
                <h4 class="modal-title" id="myModalLabel">${Id}</h4>
            </div>
            <div class="modal-body">


            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="NewTask" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">x</button>
                <h4 class="modal-title" id="myModalLabel">New Task</h4>
            </div>
            <div class="modal-body">
                <form action="/AddTask" method="POST">
                <div class="form-group">
                    <input name='TaskName' type="text" placeholder="Name" class="form-control">
                </div>
                <div class="form-group">
                    <input name='Description' type="text" placeholder="Описание" class="form-control">
                </div>
                <div class="form-group">
                    <input name='Deadline'  type="date" placeholder="Deadline" class="form-control">
                </div>


                <button type="submit" class="btn btn-success" onclick='addList()'>Add task</button>
                    </form>

            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="NewSubtask" tabindex="-1" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header"><button class="close" type="button" data-dismiss="modal">x</button>
                <h4 class="modal-title" id="myModalLabel">New subtask</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input type="number" placeholder="Number" class="form-control">
                </div>
                <div class="form-group">
                    <input type="text" placeholder="Name" class="form-control">
                </div>
                <div class="form-group">
                    <input type="text" placeholder="Кто выполняет?" class="form-control">
                </div>
                <div class="form-group">
                    <input type="date" placeholder="Deadline" class="form-control">
                </div>


                <button type="submit" class="btn btn-success" onclick='addList()'>Add subtask</button>

            </div>

        </div>
    </div>
</div>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" color = 1525>
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">TaskManager</a>
        </div>
        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" id="search" class="form-control" placeholder="Search">
                </div>

            </form>
            <ul class="nav navbar-nav">
                <li style="padding-top:8px;padding-left:0px;"><button type="button" class="btn btn-default" href="#" data-toggle="modal" data-target="#NewTask" ></but>New Task</button></li>
            </ul>
            <ul class="nav navbar-nav navbar-right" style="padding-top:8px;padding-left:15px;">
                <a class="btn btn-success" href="/Main" data-toggle="/Main" ><%=session.getAttribute("User")%></a>

            </ul>
        </div>
    </div>
</div>

<div class="container" style="margin:0 0 0 0px;padding:0px;margin-top:50px;height:100%;">
    <div class="row" style="margin:0px;height:100%;">

    </div>
</div>
</div>
<div class = "col-sm-8">
    <table id="grid" class="table table-hover">
        <thead>
        <tr>

            <th data-type="string">Номер задачи</th>
            <th data-type="string">Название задачи</th>
            <th data-type="string">Daedline</th>


        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.tasks}" var="task" varStatus="myIndex">
            <tr
            <c:choose>
                <c:when test="${task.condition!=0}">
                    class="success"  data-toggle="modal" onclick="window.location.href='/getsub?task_id=${task.task_Id}'; return false"

                </c:when>
            </c:choose>
                     data-toggle="modal" onclick="window.location.href='/getsub?task_id=${task.task_Id}'; return false"
            >
                <td>${myIndex.index+1}</td>
                <td>${task.name}</td>
                <td>${task.deadline}</td>

            </tr>
        </c:forEach>
        <tr class="success" data-toggle="modal" data-target="#Window1">
        </tr>
        </tbody>
    </table>
</div>
</div>
</div>
<!--
    <div class="container-fluid">
          <div class="row">
  <div class="row-fluid">
    <div class="span2">
  <ul class="nav nav-sidebar">
    <li><a href="">Nav item</a></li>
    <li><a href="">Nav item again</a></li>
    <li><a href="">One more nav</a></li>
    <li><a href="">Another nav item</a></li>
    <li><a href="">More navigation</a></li>
  </ul>
    </div>
    <div class="span10">

    </div>
  </div>
</div>
        </div>
-->


<!-- Здесь будет лист-->




<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<script>
    var grid = document.getElementById('grid');

    grid.onclick = function(e) {
        if (e.target.tagName != 'TH') return;

        // Если TH -- сортируем
        sortGrid(e.target.cellIndex, e.target.getAttribute('data-type'));
    };

    function sortGrid(colNum, type) {
        var tbody = grid.getElementsByTagName('tbody')[0];

        // Составить массив из TR
        var rowsArray = [].slice.call(tbody.rows);

        // определить функцию сравнения, в зависимости от типа
        var compare;

        switch (type) {
            case 'number':
                compare = function(rowA, rowB) {
                    return rowA.cells[colNum].innerHTML - rowB.cells[colNum].innerHTML;
                };
                break;
            case 'string':
                compare = function(rowA, rowB) {
                    return rowA.cells[colNum].innerHTML > rowB.cells[colNum].innerHTML ? 1 : -1;
                };
                break;
        }

        // сортировать
        rowsArray.sort(compare);

        // Убрать tbody из большого DOM документа для лучшей производительности
        grid.removeChild(tbody);

        // добавить результат в нужном порядке в TBODY
        // они автоматически будут убраны со старых мест и вставлены в правильном порядке
        for (var i = 0; i < rowsArray.length; i++) {
            tbody.appendChild(rowsArray[i]);
        }

        grid.appendChild(tbody);

    }

</script>

<script>
    var $rows = $('#grid tr');
    $('#search').keyup(function() {
        var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();

        $rows.show().filter(function() {
            var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
            return !~text.indexOf(val);
        }).hide();
    });
</script>

</body>
</html>
