<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="payment" method="get">
    <div class="container">
        <div class="row">
            <div class="col-md-4 order-md-2 mb-4">

                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-muted">Ваша корзина</span>
                </h4>

                <ul class="list-group mb-3">
                    <c:forEach var="product" items="${cartList}" varStatus="productId">
                        <li class="list-group-item d-flex justify-content-between lh-condensed ">
                            <div>
                                <h6 class="my-0 w-75">${product.title} ${product.model}</h6>
                                <small class="text-muted">${product.description}</small>
                            </div>
                            <div class="d-flex flex-column w-100 justify-content-center">
                                <span class="text-muted"
                                      style="margin-left: auto">${product.price}€</span>
                            </div>
                        </li>
                    </c:forEach>

                    <li class="list-group-item d-flex justify-content-between bg-light <c:if test="${promoCodeUsed != true}">d-none</c:if>">
                        <div class="text-success">
                            <h6 class="my-0">Промо-код</h6>
                            <small>${promoCode}</small>
                        </div>
                        <span class="text-success">-20%</span>
                    </li>

                    <li class="list-group-item d-flex justify-content-between bg-light">
                        <span>Всего (€)</span>
                        <span id="endPrice" name="endPrice" class="font-weight-bold">${endPrice}€</span>
                    </li>
                </ul>
            </div>

            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Платежный адрес</h4>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="name">Имя</label>
                        <input name="name" type="text" class="form-control" id="name"
                               value="${buyer.name}"
                               required>
                    </div>

                    <div class="col-md-6 mb-3">
                        <label for="lastname">Фамилия</label>
                        <input name="lastname" type="text" class="form-control" id="lastname"
                               value="${buyer.lastname}" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="email">Email<span class="text-muted"></span></label>
                    <input name="email" type="email" class="form-control" id="email"
                           value="${buyer.email}" required>
                </div>

                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="address">Адрес</label>
                        <input name="address" type="text" class="form-control" id="address"
                               value="${buyer.address}" required>
                    </div>

                    <div class="col-md-3 mb-3">
                        <label for="zip">Zip-код</label>
                        <input name="zip" type="text" class="form-control" id="zip" required>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="address2">Адрес 2<span class="text-muted"> (необязательно)</span></label>
                        <input name="address2" type="text" class="form-control" id="address2">
                    </div>

                    <hr class="mb-4">

                    <h4 class="mb-3">Оплата</h4>

                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="cc-name">Имя владельца карты</label>
                            <input name="cc-name" type="text" class="form-control" id="cc-name" placeholder=""
                                   required="">
                            <small class="text-muted">Полное имя написано на карте.</small>
                        </div>

                        <div class="col-md-6 mb-3">
                            <label for="cc-number">Номер карты</label>
                            <input name="cc-number" type="text" class="form-control" id="cc-number" placeholder=""
                                   required="">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <label for="cc-expiration">Срок действия</label>
                            <input name="cc-expiration" type="text" class="form-control" id="cc-expiration"
                                   placeholder="" required="">
                        </div>

                        <div class="col-md-3 mb-3">
                            <label for="cc-expiration">CVV</label>
                            <input name="cc-cvv" type="text" class="form-control" id="cc-cvv" placeholder=""
                                   required="">
                        </div>
                    </div>

                <hr class="mb-4">

                <input class="btn btn-lg btn-block" value="Продолжить" style="background-color: #EB984E" type="submit">
            </div>
        </div>
    </div>
</form>