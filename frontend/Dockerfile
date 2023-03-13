FROM node as build
WORKDIR /app
COPY package.json .
RUN npm install
COPY . .
EXPOSE 8080
RUN npm run build

FROM nginx:1.17.8-alpine
COPY --from=build /app/dist /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx/default.conf /etc/nginx/conf.d
EXPOSE 80