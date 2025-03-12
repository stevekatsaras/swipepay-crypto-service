swipepay--crypto-service
------------------------
A microservice designed to manage crypto keys and encrypt/decrypt sensitive data for users.

This component is dependent on the following AWS Services:
*. Key Management Service (KMS)

In a given environment, you will need to pass the following environment variables on startup:

aws.credentials.access-key: <IAM_USER_ACCESS_KEY>
aws.credentials.secret-key: <IAM_USER_SECRET_KEY>
aws.kms.service-endpoint: https://kms.us-west-2.amazonaws.com
aws.kms.signing-region: us-west-2
aws.kms.cmk-id: <CMK_ARN_ID>
aws.kms.data-key-algorithm: AES
aws.kms.data-key-spec: AES_128

The following are response codes that this service can return:

200 OK
400 Bad Request
	- BindException
	- MethodArgumentNotValidException
	- HttpMessageNotReadableException
	- TypeMismatchException
	- MissingServletRequestPartException
	- MissingServletRequestParameterException
	- MethodArgumentTypeMismatchException
401 Unauthorized
404 Not Found
	- NoHandlerFoundException
405 Method Not Allowed
	- HttpRequestMethodNotSupportedException
415 Unsupported Media Type
	- HttpMediaTypeNotSupportedException
500 Internal Server Error
	- FailedToDecryptException
	- FailedToEncryptException
	- Exception
502 Bad Gateway
	- CannotGenerateDataKeyException
