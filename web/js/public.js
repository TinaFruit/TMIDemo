function login() {
          var xhttp = new XMLHttpRequest();
          xhttp.onreadystatechange = function() {

            if (this.readyState == 4 && this.status > 200) {

              /*document.getElementById("error").innerHTML =
              "<font color=red size=1px>"+this.responseText+"</font>";*/
              const obj = JSON.parse(this.responseText);
              document.getElementById("error").innerHTML =
              "<font color=red size=1px>"+obj.message+"</font>";

            }
            //200--->成功,跳转到welcome.jsp
            if (this.readyState == 4 && this.status == 200) {

              window.location.href = 'welcome.jsp';

            }
          };
          xhttp.open("POST", "/LoginProject/loginServlet", true);
          xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          xhttp.send("username="+document.getElementsByName("username")[0].value+"&"+
          "password="+document.getElementsByName("password")[0].value);
        }


function gotToRegister(){
            //跳转到register.html
              window.location.href = 'register.html';
        }

function onload()
    {
    url = new URL(window.location.href);
    msg=url.searchParams.get("msg")
    if(msg != null){
    //已完成输入，回到login
    alert(msg)
    }
    }

function register(){
         var xhttp = new XMLHttpRequest();
         xhttp.onreadystatechange = function() {

                  if (this.readyState == 4 && this.status > 200) {
                    const obj = JSON.parse(this.responseText);
                  document.getElementById("error").innerHTML =
                  "<font color=red size=1px>"+obj.message+"</font>";
                  }


         //200--->成功，跳转到login + alert(Thanks for your registration.)
         if (this.readyState == 4 && this.status == 200) {
         const obj = JSON.parse(this.responseText);
         window.location.href = 'index.html?msg='+obj.message;
          }
          };


          xhttp.open("POST", "/LoginProject/registerServlet", true);
           xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            var obj = {};
                     obj.username=document.getElementsByName("username")[0].value;
                     obj.password = document.getElementsByName("password")[0].value;

                     var myJSON = JSON.stringify(Obj);
                    xhttp.send(myJSON);
          }
