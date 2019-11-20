window.addEventListener('load',function(){
  var botonSend = document.querySelector("button.send");
  botonSend.addEventListener('click', function(){
  var error = false;
  var email = document.querySelector("input.send");
  var errorEmail = document.querySelector("span.errorNewsletter");

  if(email.value == ""){
    errorNewsletter.innerHTML= "por favor ingresá tu e-mail";
    email.style.border="1px solid red";
    error = true;}
    else if{email.value.lenght<10){
      errorNewsletter.innerHTML = "el email que ingresaste no es válido";
      email.style.border = "1px solid red";
      error= true;
    }else{
      errorNewsletter.innerHTML ="";
      email.style.border = "1px solid green";
    }
  }
 })
}
)
