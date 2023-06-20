<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
        <link rel="stylesheet" href="styles.css">
        <link href="CSS/styleLogin.css" rel="stylesheet" type="text/css"/>
        <link href="CSS/styleLogin.css" rel="stylesheet" type="text/css"/>
        <title>signin-signup</title>
    </head>

    <body>
        <div class="container">
            <div class="signin-signup">
                <form action="Login" class="sign-in-form" method="post">
                    <h2 class="title">Iniciar sesión</h2>
                    <div class="input-field">
                        <i class="fas fa-user"></i>
                        <input type="email" name="email" class="form-control" id="floatingInput" placeholder="nombre@ejemplo.com">
                        <label for="floatingInput"></label>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-lock"></i>
                        <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                        <label for="floatingPassword"></label>
                    </div>
                    <input type="submit" value="Iniciar sesión" class="btn">
                    <p class="social-text">O inicia sesión con una plataforma social</p>
                    <div class="social-media">
                        <a href="#" class="social-icon">
                            <i class="fab fa-facebook"></i>
                        </a>
                        <a href="" class="social-icon">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a href="" class="social-icon">
                            <i class="fab fa-google"></i>
                        </a>
                        <a href="" class="social-icon">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                    </div>
                    <p class="account-text">¿No tienes una cuenta? <a href="#" id="sign-up-btn2">Regístrate</a></p>
                </form>


                <!--Registrar Usuario-->   

                <form action = "UsuarioControlador" method="post" class="sign-up-form" >
                    <input type="hidden" name="usuario_id" value="${usuario.usuario_id}">
                    <h2 class="title">Regístrate</h2>
                    <!--<div class="input-field">
                        <i class="fas fa-user"></i>
                        <input type="text" placeholder="Nombre de usuario">
                    </div>-->
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <label for="email" class="form-label"></label>
                        <input type="email" class="form-control" name="email" value="${usuario.email}" placeholder="Escriba su email">

                    </div>
                    <div class="input-field">
                        <i class="fas fa-lock"></i>
                        <label for="password" class="form-label"></label>
                        <input type="password" class="form-control" name="password" value="${usuario.password}" placeholder="Escriba su contraseña">
                    </div>
                    <input type="submit" value="Regístrate" class="btn">
                    <p class="social-text">O inicia sesión con una plataforma social</p>
                    <div class="social-media">
                        <a href="#" class="social-icon">
                            <i class="fab fa-facebook"></i>
                        </a>
                        <a href="" class="social-icon">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a href="" class="social-icon">
                            <i class="fab fa-google"></i>
                        </a>
                        <a href="" class="social-icon">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                    </div>
                    <p class="account-text">¿Ya tienes una cuenta? <a href="#"

                                                                      id="sign-in-btn2">Inicia sesión</a></p>
                </form>
            </div>
            <div class="panels-container">
                <div class="panel left-panel">
                    <div class="content">
                        <h3>¿Eres miembro de la marca?</h3>
                        <p>Inica Sesión para disfutrar tu musica </p>
                        <button class="btn" id="sign-in-btn">Iniciar sesión</button>
                    </div>
                    <img src="signin.svg" alt="" class="image"> <!-- Imagen -->
                </div>
                <div class="panel right-panel">
                    <div class="content">
                        <h3>¿Eres nuevo Soul?</h3>
                        <p>Registrate Gratis para escuchar tu Musica Preferida</p>
                        <button class="btn" id="sign-up-btn">Regístrate</button>
                    </div>
                    <img src="signup.svg" alt="" class="image"><!-- Imagen -->
                </div>
            </div>
        </div>
        <script src="app.js"></script>
    </body>
    <script>
        // Aquí colocas tu código JavaScript
        const sign_in_btn = document.querySelector("#sign-in-btn");
        const sign_up_btn = document.querySelector("#sign-up-btn");
        const container = document.querySelector(".container");
        const sign_in_btn2 = document.querySelector("#sign-in-btn2");
        const sign_up_btn2 = document.querySelector("#sign-up-btn2");

        sign_up_btn.addEventListener("click", () => {
            container.classList.add("sign-up-mode");
        });

        sign_in_btn.addEventListener("click", () => {
            container.classList.remove("sign-up-mode");
        });

        sign_up_btn2.addEventListener("click", () => {
            container.classList.add("sign-up-mode2");
        });
        sign_in_btn2.addEventListener("click", () => {
            container.classList.remove("sign-up-mode2");
        });
    </script>
</html>