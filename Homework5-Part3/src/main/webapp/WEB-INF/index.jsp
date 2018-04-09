<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <script>
            function btn_click(){
                var e = document.getElementById("opt");
                var strUser = e.options[e.selectedIndex].value;
                if(strUser === 'add'){
                window.location.assign("addMovie.htm");
                }
                else{
                window.location.assign("searchMovie/");
                }
                return false;
            }
        </script>
    </head>

    <body>
        <h1>Welcome to our Movie Store</h1>
        <br>
        <p>Please Make your selection below :</p>
        <br>    
        <div>
            <select id="opt">
                <option value="browse">Browse Movies</option>
                <option value="add">Add New Movies in Database</option>
            </select>
            
            <button value="Send" onclick="btn_click()">Send</button>
        </div>
    </body>
</html>
