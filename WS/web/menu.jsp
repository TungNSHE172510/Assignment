<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">Trang chủ</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                        <c:if test="${sessionScope.a != null}"> 
                        <li class="nav-item">
                            <a class="nav-link" href="#">Xin chào ${sessionScope.a.user}</a>
                        </li>
                        </c:if>
                        <c:if test="${sessionScope.a.isAdmin == 1}"> 
                        <li class="nav-item">
                            <a class="nav-link" href="#">Quản lí tài khoản</a>
                        </li>
                        </c:if>
                        <c:if test="${sessionScope.a.isSell == 1}"> 
                        <li class="nav-item">
                            <a class="nav-link" href="productmanage">Quản lí sản phẩm</a>
                        </li>
                        </c:if>
                        <c:if test="${sessionScope.a != null}"> 
                        <li class="nav-item">
                            <a class="nav-link" href="logout">Đăng xuất</a>
                        </li>
                        </c:if>
                        <c:if test="${sessionScope.a == null}"> 
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp">Đăng nhập</a>
                        </li>
                        </c:if>
                    </ul>

                    <form action="search" method="get" class="form-inline my-2 my-lg-0">
                        
                        <div class="input-group input-group-sm">
                            <div class="form-group">
                                <label></label>
                                <select name="sprice" class="form-select" aria-label="Default select example">
                          
                                        <option value="1">Gia toi thieu</option>
                                        <option value="2">GIa toi da</option>

                                </select>
                            </div>
                            <input value="${SearchValue}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="show">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">3</span>
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Siêu thị nồi cơm</h1>
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu</p>
            </div>
        </section>
        <!--end of menu-->