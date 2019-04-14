<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
    <link rel="stylesheet" href="resources/css/header.css">
</head>
<body class="text-center">
<div class="w-100 h-100">
    <header>
        <div class="overlay"></div>
        <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
            <source src="https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4" type="video/mp4">
        </video>
        <div class="container h-100">
            <div class="d-flex h-100 text-center align-items-center">
                <div class="w-100 text-white">
                    <h1 class="display-3">Video store</h1>

                </div>
            </div>
        </div>
    </header>

    <section class="my-5">
        <div class="container">
            <div class="row">
                <div class="col-md-8 mx-auto">
                    <p class="lead mb-0">Video store offers you a large selection of products to order. To make a purchase
                        requires authorization in the system.</p>
                    <p class="lead mb-0">
                        <a href="login" class="btn btn-lg btn-secondary">Log in</a>
                    </p>
                </div>
            </div>
        </div>
    </section>

    <footer class="mastfoot mt-auto">
        <div class="inner">
            <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
        </div>
    </footer>
</div>
</body>
</html>