<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<h3 class="w-100 text-center my-5">Добавить новый товар</h3>
<div class="row w-100">
    <label class="text-center w-25 mx-auto">
        <a href="uploadForm" class="w-100 col-4 mx-auto btn btn-outline-primary btn-lg">Загрузить обложку для
            товара
        </a>
    </label>

    <p class="fw-bold text-muted text-center mt-5">Данные товара</p>

    <form action="createProduct" method="POST">
        <div class="input-group flex-nowrap w-25 my-3 mx-auto">
            <span class="input-group-text">Категория</span>
            <select class="form-select" name="collectionId" required>
                <c:forEach var="collection" items="${collectionList}" varStatus="collectionId">
                    <option value="${collection.id}">${collection.collectionName}</option>
                </c:forEach>
            </select>
            <a type="button" class="btn btn-outline-primary" href="addCollection">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clipboard-plus" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M8 7a.5.5 0 0 1 .5.5V9H10a.5.5 0 0 1 0 1H8.5v1.5a.5.5 0 0 1-1 0V10H6a.5.5 0 0 1 0-1h1.5V7.5A.5.5 0 0 1 8 7z"></path>
                    <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"></path>
                    <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"></path>
                </svg>
                <span class="visually-hidden">Button</span>
            </a>
            <a type="button" class="btn btn-outline-danger" href="removeCollection">
                <svg width="16" height="16" viewBox="0 0 100 100" xmlns="http://www.w3.org/2000/svg">
                    <defs></defs>
                    <g id="2.-Minus" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" stroke-linecap="round" stroke-linejoin="round">
                        <g transform="translate(2.000000, 2.000000)" stroke="#FF6B6B" stroke-width="4">
                            <circle id="Layer-1" cx="48" cy="48" r="48"></circle>
                            <path d="M76.8159956,47.9840044 L19.2159956,47.9840044" id="Layer-2"></path>
                        </g>
                    </g>
                </svg>
            </a>
        </div>
        <div class="input-group flex-nowrap w-25 my-3 mx-auto">
            <span class="input-group-text">Модель товара</span>
            <input type="text" class="form-control" placeholder="MT482" id="model"
                   name="model" value="${model}" required>
        </div>
        <div class="input-group flex-nowrap w-25 my-3 mx-auto">
            <span class="input-group-text">Цена товара</span>
            <input type="number" min="1" max="10000" class="form-control" placeholder="500€" id="price" value="${price}"
                   name="price" required>
        </div>
        <div class="input-group flex-nowrap w-25 my-3 mx-auto">
            <span class="input-group-text">Количество</span>
            <input type="number" min="1" max="1000" class="form-control" placeholder="1" id="count" value="${count}"
                   name="count" required>
        </div>

        <p class="fw-bold text-muted text-center mt-5">Обложка товара</p>

        <div class="row w-50 my-2 mx-auto">
            <div class="col-8 text-start w-50 mx-auto">
                <select class="form-select" name="coverId" aria-label="Выбрать обложку" required>
                    <option selected>Выберите обложку для товара:</option>
                    <c:forEach var="cover" items="${listCovers}">
                        <option value="${cover.id}">${cover.description}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="w-50 mx-auto mt-5" style="margin-bottom: 10rem">
            <div class="mx-auto w-25">
                <input class="btn mx-auto w-100" style="background-color: #EB984E" type="submit" name="submit" value="Добавить товар">
            </div>
        </div>
    </form>
</div>

<style>
    .btn-outline-primary{
        color: #EB984E;
        outline: none;
        border: 1px solid #EB984E;
    }
    .btn-outline-primary:hover{
        background-color: #EB984E;
        border: 1px solid #EB984E;
    }
    .btn-outline-primary:focus{
        --bs-primary: #EB984E;
    }
</style>