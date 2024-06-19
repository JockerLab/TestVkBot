# Установка ngrok
Перед запуском приложения необходимо установить Ngrok (https://ngrok.com/).
С помощью следующей команды получаем наш http адрес и подставляем в url бота в ВК:

`ngrok http 8080`

**P.S.** порт 8080 используется по умолчанию в Spring, при необходимости его нужно изменить.
# Параметры конфигурации
Параметры конфигурации, такие как:
- `VK_API_TOKEN` — ключ доступа к API ВК;
- `VK_API_VERSION` — используемая версия API ВК;
- `VK_BOT_CONFIRMATION_TOKEN` — токен подтверждения адреса бота;
- `VK_BOT_SECRET` — секретный ключ;
- `VK_BOT_ID` — id бота;
- `VK_BOT_URL` — адрес бота (из ngrok)

скрыты в конфигурационном файле env.properties.

# Запуск приложения
Командой `./mvnw spring-boot:run` в терминале в корневой папке.
Либо через IDE запустить приложение VkBotApplication.

# Пример работы
![Example image](https://github.com/JockerLab/TestVkBot/blob/main/example.png)