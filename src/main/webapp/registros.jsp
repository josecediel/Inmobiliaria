<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

        <title>Control de registros</title>
    </head>
    <body>
        <!--Cabecero-->
        <header id="main-header" class="py-2 bg-info text-white">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>
                            <i class="fas fa-cog"></i> Control de Clientes</h1>
                    </div>
                </div>
            </div>
        </header>
        
        <!--Botonera-->
        
        <section id="clientes">
            <div class="container">
                <div class="row">

                    <div class="col-md-3">
                        <div class="card">
                            <div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
                                <div class="card-header">Header</div>
                                <div class="card-body">
                                    <h5 class="card-title">Primary card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                            </div>
                        </div> 
                    </div>

                    <div class="col-md-3">

                        <div class="card">
                            <div class="card text-white bg-success mb-3" style="max-width: 18rem;">
                                <div class="card-header">Header</div>
                                <div class="card-body">
                                    <h5 class="card-title">Success card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="card">
                            <div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
                                <div class="card-header">Header</div>
                                <div class="card-body">
                                    <h5 class="card-title">Secondary card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                            </div>
                        </div> 
                    </div>

                    <div class="col-md-3">
                        <div class="card">
                            <div class="card text-white bg-danger mb-3" style="max-width: 18rem;">
                                <div class="card-header">Header</div>
                                <div class="card-body">
                                    <h5 class="card-title">Danger card title</h5>
                                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                </div>
                            </div>
                        </div> 
                    </div>

                    <div class="row">

                        <div class="col-md-3">
                            <div class="card">
                                <div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
                                    <div class="card-header">Header</div>
                                    <div class="card-body">
                                        <h5 class="card-title">Primary card title</h5>
                                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    </div>
                                </div>
                            </div> 
                        </div>

                        <div class="col-md-3">

                            <div class="card">
                                <div class="card text-white bg-success mb-3" style="max-width: 18rem;">
                                    <div class="card-header">Header</div>
                                    <div class="card-body">
                                        <h5 class="card-title">Success card title</h5>
                                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <div class="card">
                                <div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
                                    <div class="card-header">Header</div>
                                    <div class="card-body">
                                        <h5 class="card-title">Secondary card title</h5>
                                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    </div>
                                </div>
                            </div> 
                        </div>

                        <div class="col-md-3">
                            <div class="card">
                                <div class="card text-white bg-danger mb-3" style="max-width: 18rem;">
                                    <div class="card-header">Header</div>
                                    <div class="card-body">
                                        <h5 class="card-title">Danger card title</h5>
                                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    </div>
                                </div>
                            </div> 
                        </div>
                    </div>

                </div>

            </div>

        </section>
        <!--LIstado-->
        <ul>
            <c:forEach var="registro" items="${registros}">
                <li>${registro.id} ${registro.tipo} ${registro.operation} ${registro.provincia} ${registro.vendedor}</li>
                </c:forEach>
        </ul>

        <!--Pie de pagina-->

        <footer id="pie-pagina" class="bg-warning text-white mt-5 p-5">
            <div class="container">
                <div class="col">
                    <p class="lead text-center">
                        Copyright &copy; GlobalMentoring.com.mx
                    </p>
                </div>
            </div>
        </footer>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
