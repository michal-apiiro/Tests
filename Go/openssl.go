import(
	"github.com/spacemonkeygo/openssl"
)

func main(){
	log.Fatal(openssl.ListenAndServeTLS(
			":8443", "my_server.crt", "my_server.key", myHandler))
			ctx, err := openssl.NewCtxFromFiles("my_server.crt", "my_server.key")
	if err != nil {
			log.Fatal(err)
	}
	l, err := openssl.Listen("tcp", ":7777", ctx)
	ctx, err := NewCtx()
	if err != nil {
			log.Fatal(err)
	}
	err = ctx.LoadVerifyLocations("/etc/ssl/certs/ca-certificates.crt", "")
	if err != nil {
			log.Fatal(err)
	}
	conn, err := openssl.Dial("tcp", "localhost:7777", ctx, 0)

}
