FROM node:16
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm install
COPY . .
EXPOSE 3010
RUN npm run build:prod
CMD [ "npm", "run", "srv" ]
