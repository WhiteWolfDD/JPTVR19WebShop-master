<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<c:if test="${empty listProducts}">
    <div class="d-flex h-100 w-50 mx-auto my-auto main_cart shadow" style="background-color: #FFFFFF">
        <div class="d-flex flex-column mx-auto my-auto">
            <svg xmlns="http://www.w3.org/2000/svg" width="128" height="128" fill="currentColor"
                 class="bi bi-bookmark-x-fill" viewBox="0 0 16 16" style="margin: 0 auto; margin-bottom: 1rem; margin-top: 5rem">
                <path fill-rule="evenodd"
                      d="M2 15.5V2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v13.5a.5.5 0 0 1-.74.439L8 13.069l-5.26 2.87A.5.5 0 0 1 2 15.5zM6.854 5.146a.5.5 0 1 0-.708.708L7.293 7 6.146 8.146a.5.5 0 1 0 .708.708L8 7.707l1.146 1.147a.5.5 0 1 0 .708-.708L8.707 7l1.147-1.146a.5.5 0 0 0-.708-.708L8 6.293 6.854 5.146z"></path>
            </svg>
            <h2 class="text-center mb-3">Товаров нет :(</h2>
            <span class="text-muted mb-2"
                  style="font-size: 18px">Возможно, они скоро появятся :)</span>
            <a href="index" class="btn w-50 mx-auto mt-4"
               style="margin-bottom: 5rem; background-color: #EB984E">Главная</a>
        </div>
    </div>
</c:if>

<div class="w-50 mx-auto d-flex justify-content-center m-2 flex-wrap <c:if test="${empty listProducts}">d-none</c:if>" style="<c:if
        test="${not empty listProducts}">background-color: #FFFFFF; padding-bottom: 2rem; border-radius: 15px</c:if>">
    <h2 class="w-100 text-center mt-4">Список товаров</h2>
    <h3 class="text-center mt-4 text-danger"><c:if test="${empty listProducts}">Список товаров пуст.</c:if></h3>
    <c:forEach var="product" items="${listProducts}" varStatus="productId">
        <div class="card m-2 mt-4 d-flex" style="width: 13.5rem">
            <img src="insertCover/${product.cover.path}" class="card-img-top" alt="..."
                 style="max-width: 12rem; max-height: 360px; margin: 11px auto 0;">
            <div style="height: 228px; margin-top: auto; padding: 16px">
                <h5 class="card-title"
                    style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis; max-width: 12rem; line-height: 2rem">${product.title} ${product.model}</h5>
                <p class="card-text"
                   style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis; max-width: 12rem; margin-bottom: 2px; margin-top: 6px">
                    Цена:
                    <strong>${product.price}€</strong></p>
                <p class="card-text">Наличие: <c:if test="${product.count < 1}"><strong><i>Нет</i></strong>
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                         class="bi bi-clock-fill" viewBox="0 0 24 24" style="fill: red; margin-top: 6px">
                        <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM8 3.5a.5.5 0 0 0-1 0V9a.5.5 0 0 0 .252.434l3.5 2a.5.5 0 0 0 .496-.868L8 8.71V3.5z"></path>
                    </svg>
                </c:if>
                    <c:if test="${product.count > 0}"><strong><i>Есть</i></strong>
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                             style="fill: #32CD32; margin-top: 6px"
                             class="bi bi-check-circle-fill" viewBox="0 0 24 24">
                            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"></path>
                        </svg>
                    </c:if>
                </p>

                <div class=" d-flex flex-nowrap justify-content-between">
                    <form action="addToBag">
                        <a href="addToBag?productId=${productId.count}"
                                class="btn <c:if test="${product.count < 1}">disabled</c:if>" style="background-color: #EB984E"
                                data-bs-target="#addToBagConfirmation${productId.index}" data-bs-toggle="modal"
                                id="productId=${productId.count}">
                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor"
                                 class="bi bi-bag" viewBox="0 0 16 16">
                                <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"></path>
                            </svg>
                        </a>
                    </form>

                    <form action="buyProductForm" method="post">
                        <a href="buyProductForm?productId=${productId.count}"
                           data-bs-target="#buyProductFormConfirmation${productId.index}" data-bs-toggle="modal"
                           id="confirmationButton${productId.count}"
                           class="btn <c:if test="${product.count < 1}">disabled</c:if>" style="background-color: #EB984E">Купить сразу</a>
                    </form>
                </div>
                <div class="w-100 mt-2">
                    <button data-bs-target="#exampleModal${productId.count}" data-bs-toggle="modal"
                            id="viewDetailButton${productId.count}"
                            class="btn w-100 <c:if test="${product.count < 1}">disabled</c:if>" style="background-color: #EB984E">
                        Смотреть
                    </button>
                </div>
            </div>
        </div>

        <div class="modal fade" id="exampleModal${productId.count}" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Описание товара
                        </h5>
                        <button type="button" class="btn-close"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p class="font-weight-bold">Товар <span class="font-weight-normal">${product.title} ${product.model}</span></p>
                        <p class="text-muted font-weight-bold">Описание: <br> <span class="font-weight-normal">${product.description}</span></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn" data-bs-dismiss="modal" style="background-color: #EB984E">Закрыть
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="buyProductFormConfirmation${productId.index}" tabindex="-1"
             aria-labelledby="buyProductFormConfirmationModal"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="buyProductFormConfirmationModal">Подтверждение покупки</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p>Вы уверены, что хотите купить товар "<strong>${product.title} ${product.model}</strong>" за
                            <strong>${product.price}</strong>€</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Нет</button>
                        <a href="buyProductForm?productId=${productId.count}" type="button" class="btn" style="background-color: #EB984E">Да</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="addToBagConfirmation${productId.index}" tabindex="-1"
             aria-labelledby="addToBagConfirmationModal"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addToBagConfirmationModal">Уведомление</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p>Хотите ли Вы добавить товар "<strong>${product.title} ${product.model}</strong>" в корзину?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Нет</button>
                        <a href="addToBag?productId=${productId.count}" type="button" class="btn" style="background-color: #EB984E">Да</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
