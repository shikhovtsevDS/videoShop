<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="fragments/headTag.jsp"/>
</head>
<body class="text-center">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
    <header class="masthead mb-auto">
        <div class="inner">
            <h3 class="masthead-brand">Video store</h3>
            <nav class="nav nav-masthead justify-content-center">
                <a class="nav-link active" href="/" aria-disabled="true">Home</a>
                <a class="nav-link" href="products">Products</a>
                <a class="nav-link" href="login">Log in</a>
            </nav>
        </div>
    </header>

    <main role="main" class="inner cover">
        <h1 class="cover-heading">Store</h1>
        <p class="lead">Video store offers you a large selection of products to order. To make a purchase requires authorization in the system.</p>
        <p class="lead">
            <a href="login" class="btn btn-lg btn-secondary">Log in</a>
        </p>
    </main>

    <footer class="mastfoot mt-auto">
        <div class="inner">
            <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
        </div>
    </footer>
</div>
</body>
</html>