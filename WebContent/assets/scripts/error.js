function login_error(){
    swal({
        title: "Sorry!",
        text: "Please, Enter your valid email-id and password. Thank You!",
        icon: "error",
        dangerMode: true,
              
        buttons:{               
            confirm:{ 
                text: "RETRY ?",
                value: "retry",
            },
        },
    })
    .then((value) => {
        if(`${value}` == "retry")
        {
              return false;
        }
    });
}