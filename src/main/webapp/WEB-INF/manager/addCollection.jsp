<%@page contentType="text/html" pageEncoding="UTF-8" %>
<h3 class="text-center">Добавить категорию</h3>
<form action="createCollection" class="mt-5" method="get">

    <div class="input-group flex-nowrap w-25 my-3 mx-autoo">
        <select name="collection" multiple disabled class="mt-2 mx-auto w-50 form-select">
            <option value="">Выберите роль</option>
            <c:forEach var="collection" items="${collectionList}" varStatus="collectionId">
                <option value="${collection.id}">
                        ${collection.collectionName}
                </option>
            </c:forEach>
        </select>
    </div>

    <div class="input-group flex-nowrap w-25 my-3 mx-auto">
        <span class="input-group-text">Категория</span>
        <input class="form-control" type="text" name="collectionName" id="collectionName" placeholder="Угловой диван">
    </div>
    <div class="row w-25 mx-auto mt-5">
        <div class="w-50 mx-auto">
            <input type="submit" class="btn btn-primary w-100" value="Загрузить файл">
        </div>
    </div>
</form>