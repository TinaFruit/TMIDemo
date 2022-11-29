function loadDoc() {
          var xhttp = new XMLHttpRequest();
          xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 404) {
              const obj = JSON.parse(this.responseText)
              document.getElementById("demo").innerHTML =
              "<font color=red>"+obj.error+"</font>";
            }
            if (this.readyState == 4 && this.status == 200) {
              document.getElementById("demo").innerHTML =
              this.responseText;
            }
          };

          xhttp.open("POST", "/LoginProject/AddCart", true);
          xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          xhttp.send("name=item1288431&quantity="+ document.getElementById("quantity").value);
        }

