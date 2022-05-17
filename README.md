# luci-pizza

To run with docker use:
`docker-compose up -d`

By default it runs on port `80`

Project uses spring boot <code>data-rest</code> starter, so you can access and populate tables with pizza's options and sizes in easy way.\
Go to <code>localhost</code> and check available endpoints:

>{\
    "_links": {\
        "pizzaOptions": {\
            "href": "http://localhost/pizzaOptions{?page,size,sort}", \
            "templated": true\
        },\
        "pizzaSizes": {\
            "href": "http://localhost/pizzaSizes{?page,size,sort}", \
            "templated": true\
        },\
        "orders": {\
            "href": "http://localhost/orders{?page,size,sort}", \
            "templated": true\
        },\
        "profile": {\
            "href": "http://localhost/profile"\
        }\
    }\
}