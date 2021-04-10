<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${empty cartList}">
    <div class="d-flex w-50 mx-auto my-auto main_cart shadow"
         style="background-color: #FFFFFF">
        <div class="d-flex flex-column mx-auto my-auto">
            <svg xmlns="http://www.w3.org/2000/svg"
                 style="margin: 0 auto; margin-bottom: 1rem; margin-top: 5rem"
                 width="128" height="128" fill="currentColor" class="bi bi-cart-x-fill"
                 viewBox="0 0 16 16">
                <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zM7.354 5.646L8.5 6.793l1.146-1.147a.5.5 0 0 1 .708.708L9.207 7.5l1.147 1.146a.5.5 0 0 1-.708.708L8.5 8.207 7.354 9.354a.5.5 0 1 1-.708-.708L7.793 7.5 6.646 6.354a.5.5 0 1 1 .708-.708z"></path>
            </svg>
            <h2 class="text-center mb-3">Корзина пуста :(</h2>
            <span class="text-muted mb-2"
                  style="font-size: 18px">Добавьте что-нибудь, чтобы сделать меня счастливым :)</span>
            <a href="listProducts" class="btn w-50 mx-auto mt-2"
               style="margin-bottom: 5rem; background-color: #EB984E">Продолжить покупки</a>
        </div>
    </div>
</c:if>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-10 col-11 mx-auto">
            <div class="row mt-5 gx-3">
                <div class="col-md-12 col-lg-8 col-11 mx-auto main_cart mb-lg-0 mb-5 shadow">
                    <c:if test="${not empty cartList}">
                        <div class="d-flex flex-row justify-content-between">
                            <h4 class="py-4 font-weight-bold m-0">Товаров в корзине: ${productCount}</h4>
                        </div>
                    </c:if>

                    <c:forEach var="product" items="${cartList}" varStatus="productId">
                        <div class="card p-4">
                            <div class="row">
                                <div class="col-md-5 col-11 bg-light shadow w-25" style="padding: 1rem">
                                    <img src="insertCover/${product.cover.path}" class="card-img-top"
                                         alt="cart img"
                                         style="margin: auto auto; max-width: 12rem; max-height: 15rem;">
                                </div>

                                <div class="col-md-7 col-11 mx-auto px-4 mt-2">
                                    <div class="d-flex justify-content-between">
                                        <div class="w-50">
                                            <h5>${product.title}</h5>
                                            <p class="mb-2 text-muted text-uppercase small"
                                               style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis">${product.description}</p>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-8 mt-4">
                                            <form action="deleteFromCart" method="post">
                                                <a href="deleteFromCart?productId=${product.id}"
                                                   id="productId=${product.id}"
                                                   style="text-decoration: none; font-weight: 500">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="20"
                                                         height="20"
                                                         fill="currentColor" class="bi bi-trash-fill"
                                                         viewBox="0 0 16 16">
                                                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"></path>
                                                    </svg>
                                                    Удалить
                                                </a>
                                            </form>
                                        </div>

                                        <div class="col-4 d-flex justify-content-end price_money mt-4">
                                            <h3 hidden><span id="itemval1"></span></h3>
                                            <h4>${product.price}€</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                    </c:forEach>
                </div>


                <div class="col-md-12 col-lg-4 col-11 mx-auto mt-lg-0 mt-md-5 <c:if test="${empty cartList}">d-none</c:if>">
                    <div class="right_side p-3 shadow bg-white">
                        <h2 class="cart_name mb-5">Общая сумма</h2>
                        <div class="price_indiv d-flex justify-content-between">
                            <p>Цена товара(ов)</p>
                            <p>
                                <span>${totalPrice}</span>€
                            </p>
                        </div>
                        <div class="price_indiv d-flex justify-content-between">
                            <p>Стомость доставки</p>
                            <p><span>5</span>€</p>
                        </div>
                        <div class="price_indiv d-flex justify-content-between">
                            <p>Налог на добавленную стоймость (НДС)</p>
                            <p><span>20</span>%</p>
                        </div>
                        <hr/>
                        <div class="total-amt d-flex justify-content-between font-weight-bold">
                            <p>Общая сумма (с учетом НДС) </p>
                            <p><span>${endPrice}</span>€</p>
                        </div>
                        <a href="paymentForm?userId=${user.id}"
                           class="btn text-uppercase" style="background-color: #EB984E">Оплатить</a>
                    </div>

                    <form action="usePromoCode" method="get">
                        <div class="mt-3 shadow <c:if test="${promoCodeUsed eq true}">d-none</c:if>">
                            <div class="card">
                                <div class="card-body">
                                    <span>Введите промо-код (необязательно)</span>
                                    <div class="mt-2">
                                        <input type="text" name="promoCode" id="promoCode"
                                               class="form-control font-weight-bold"
                                               value="<c:if test="${promoCodeUsed}">${promoCode}</c:if>"
                                               placeholder="Введите промо-код"
                                               <c:if test="${promoCodeUsed}">disabled</c:if>>
                                    </div>
                                    <input class="btn btn-sm mt-2" style="background-color: #EB984E" value="Применить" type="submit">
                                </div>
                            </div>
                        </div>
                    </form>

                    <div class="mt-3 shadow p-3 bg-white">
                        <div class="pt-4">
                            <h5 class="mb-4">Примерная дата доставки</h5>
                            <p>${approxShippingDate} - ${finalApproxShippingDate}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"
        integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/"
        crossorigin="anonymous"></script>