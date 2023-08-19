<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-3">
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase">Danh mục</div>
        <ul class="list-group category_block">
            <c:forEach items="${listC}" var="o">
                <li class="list-group-item text-white ${tag == o.cid ? "":""}"><a href="category?cid=${o.cid}">${o.cname}</a></li>
            </c:forEach>
            
        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase">Hãng</div>
        <ul class="list-group category_block">
            <c:forEach items="${listM}" var="o">
                <li class="list-group-item text-white ${tag == o.mid ? "":""}"><a href="manufacturer?mid=${o.mid}">${o.mname}</a></li>
            </c:forEach>
            
        </ul>
    </div>
    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Sản phẩm mới nhất</div>
        <div class="card-body">
            <img class="img-fluid" src="${last.image}" />
            <a href="detail?pid=${last.id}" title="View Product">${o.name}<h5 class="card-title">${last.name}</h5></a>
            <p class="card-text">${last.title}</p>
            <p class="bloc_left_price">${last.price} VND</p>
        </div>
    </div>
</div>