# 📌 **Разбор ****`application.properties`**** в Spring Boot на профессиональном уровне**

##  **Назначение файла ****`application.properties`**

В Spring Boot файл `application.properties` (или `application.yml`) выполняет роль **централизованного конфигурационного хранилища** для приложения. Он используется для:\
✔ **Декларативного управления параметрами приложения** без изменения кода.\
✔ **Оптимизации развертывания** на разных средах (dev, prod, test).\
✔ **Гибкой настройки интеграции** с базами данных, логированием, безопасностью и т. д.\
✔ **Минимизации зависимостей от аннотаций** и явного конфигурирования через Java-код.

---

##  **Как Spring Boot обрабатывает ****`application.properties`****?**

Spring Boot использует **механизм автоматической конфигурации** (`Spring Boot AutoConfiguration`).

### **🛠️ Алгоритм работы:**

1️⃣ **Spring Boot запускается** и сканирует `classpath`.\
2️⃣ **Находит файл** `application.properties` или `application.yml` в `src/main/resources`.\
3️⃣ **Загружает свойства в ****`Environment`** (специальный объект Spring).\
4️⃣ **Применяет свойства** к компонентам приложения (`DataSource`, `JPA`, `Security` и т. д.).\
5️⃣ **Создаёт ****`ApplicationContext`**, используя конфигурацию.

---

##  **Основные разделы ****`application.properties`**

### **1️⃣ Подключение к базе данных**

Spring Boot использует `spring.datasource` для настройки базы данных.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=1234
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.hikari.maximum-pool-size=10
```

 **Как это работает?**

- **Spring Boot автоматически создаёт ****`DataSource`** на основе этих параметров.
- Использует **HikariCP (по умолчанию) как пул соединений**.
- При инициализации **автоматически регистрирует ****`EntityManager`** и `TransactionManager`.

---

### **2️⃣ Настройка Hibernate и JPA**

Spring Boot интегрируется с Hibernate через Spring Data JPA.

```properties
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

 **Разбор ключевых параметров:**

- `spring.jpa.database-platform` — указывает **диалект SQL** (для MySQL, PostgreSQL и др.).
- `spring.jpa.hibernate.ddl-auto` — управляет **схемой БД** (`create`, `update`, `validate`, `none`).
- `spring.jpa.show-sql=true` — включает **логирование SQL-запросов** в консоль.
- `spring.jpa.properties.hibernate.format_sql=true` — форматирует SQL-запросы для удобства чтения.

 **Spring Boot автоматически настраивает ****`EntityManagerFactory`**** и ****`TransactionManager`****.**

---

### **3️⃣ Настройки веб-сервера**

Spring Boot использует встроенный сервер (Tomcat, Jetty, Undertow).

```properties
server.port=8081
server.servlet.context-path=/api
server.error.include-message=always
server.tomcat.max-threads=200
```

 **Как это работает?**

- `server.port=8081` — изменяет стандартный порт (по умолчанию `8080`).
- `server.servlet.context-path=/api` — добавляет префикс `/api` ко всем эндпоинтам.
- `server.error.include-message=always` — включает отображение сообщений ошибок.
- `server.tomcat.max-threads=200` — задаёт **лимит потоков** для обработки запросов.

 **Spring Boot автоматически конфигурирует и запускает встроенный сервер.**

---

### **4️⃣ Логирование в Spring Boot**

Spring Boot использует **SLF4J + Logback** для логирования.

```properties
logging.level.root=INFO
logging.level.org.springframework=DEBUG
logging.file.name=logs/app.log
logging.pattern.console=%d{yyyy-MM-dd HH:mm:ss} - %msg%n
```

 **Разбор параметров:**

- `logging.level.root=INFO` — задаёт глобальный уровень логирования (`DEBUG`, `INFO`, `WARN`, `ERROR`).
- `logging.level.org.springframework=DEBUG` — включает отладку Spring-компонентов.
- `logging.file.name=logs/app.log` — записывает логи в файл.
- `logging.pattern.console` — настраивает формат логов в консоли.

 **Spring Boot автоматически настраивает логирование без дополнительных зависимостей.**

---

### **5️⃣ Настройки безопасности Spring Security**

Spring Security по умолчанию включает базовую аутентификацию.

```properties
spring.security.user.name=admin
spring.security.user.password=secret
spring.security.user.roles=USER,ADMIN
```

 **Как это работает?**

- Spring Boot **автоматически создаёт ****`UserDetailsService`** с этими учётными данными.
- Можно настроить **авторизацию ролей** (`USER`, `ADMIN`).
- Пароль **по умолчанию шифруется** через `BCryptPasswordEncoder`.

 **Можно переопределить стандартные настройки через ****`SecurityConfig`****.**

---

##  **Вывод**

✔ **`application.properties`**** — это централизованный конфигурационный файл, который управляет поведением Spring Boot-приложения.**\
✔ **Автоматическая загрузка конфигурации** упрощает развертывание.\
✔ **Гибкость** позволяет адаптировать приложение под разные среды (dev, test, prod).\
✔ **Избегает хардкодинга** и повышает читаемость кода.

 **Использование ****`application.properties`**** делает разработку более профессиональной и управляемой!** 
