//jquery
$(document).ready(async function(){
    //////
    await loadData(); // 5p mới chạy xong
    stopLoading();
    initEvent();
});


function stopLoading(){
    $('.loader').css("display", "none")
}

function initEvent(){
    $('#btnSearch').click(function(e){
        var product = $('#txtProduct').val().toLowerCase();
        var price = $('#txtPrice').val();
        $('#lstProduct').empty();
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "https://dummyjson.com/products",
            dataType: 'json',
            success: function (data) {
                var products = data.products;
                var component = $('#lstProduct');

                var filterProducts = [];

                if(product){
                    filterProducts = products.filter(item => {
                        if(item.title.toLowerCase().includes(product)){
                            return item;
                        }
                    });

                    if(price != 0){
                        filterProducts = filterProducts.filter(item => {
                            switch(price){
                                 case '1': // < 100
                                     if(item.price < 100){
                                         return item;
                                     }
                                     break;
                                 case '2': // 100 - 500
                                     if(item.price >= 100 && item.price < 500){
                                         return item;
                                     }
                                     break;
                                 case '3': // 500 - 1000
                                     if(item.price >= 500 && item.price < 1000){
                                         return item;
                                     }
                                     break;
                                 case '4': // > 1000
                                     if(item.price > 1000){
                                         return item;
                                     }
                                     break;
                            }
                         })
                    }
                }
                else{
                    filterProducts = products.filter(item => {
                       switch(price){
                            case '1': // < 100
                                if(item.price < 100){
                                    return item;
                                }
                                break;
                            case '2': // 100 - 500
                                if(item.price >= 100 && item.price < 500){
                                    return item;
                                }
                                break;
                            case '3': // 500 - 1000
                                if(item.price >= 500 && item.price < 1000){
                                    return item;
                                }
                                break;
                            case '4': // > 1000
                                if(item.price > 1000){
                                    return item;
                                }
                                break;
                       }
                    })
                }

                filterProducts.forEach(item => {
                    component.append(
                        ` 
                            <div class="item">
                                <div class="item-title">${item.title} </div> <br/>
                                <img src="${item.thumbnail}"> <br/>
                                <div class="item-price">${item.price}</div>
                            </div>
                        `
                    );
                })
            },
            error: function (e) {
    
    
            }
        });
    })
}

// Jquery gọi API
async function loadData(){
    // URL API : https://dummyjson.com/products - GET
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "https://dummyjson.com/products",
        dataType: 'json',
        success: function (data) {
            var products = data.products;
            var component = $('#lstProduct');
            products.forEach(item => {
                component.append(
                    ` 
                        <div class="item">
                            <div class="item-title">${item.title} </div> <br/>
                            <img src="${item.thumbnail}"> <br/>
                            <div class="item-price">${item.price}</div>
                        </div>
                    `
                );
            })
        },
        error: function (e) {


        }
    });
}

