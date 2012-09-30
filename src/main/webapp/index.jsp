<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<h2>Customer SignUp Form - JSR303 @Valid example</h2>
    <form method="POST" action="/spring-mvc-test/signup">
        <input name="customers[0].name">
        <input name="customers[0].age">
        <input name="customers[1].name">
        <input name="customers[1].age">
        <input type="submit">
    </form>


</body>
</html>