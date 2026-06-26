import ApiFramework from "../api/api-framework.js";

export default class SnakeService {
    apiFramework = new ApiFramework("../restservices/");

    async getSnake() {
        //TODO: haal deze data van de server
        return await this.apiFramework.getRequest("snake/");
        // return Promise.resolve({
        //     apiversion: "1",
        //     author: "de dapper student",
        //     color: "#ff0000",
        //     head: "default",
        //     tail: "default",
        //     version: "0.1"
        // });
    }

    async updateSnake(updatedSnake) {
        return await this.apiFramework.putRequest("snake/", {"body": updatedSnake});
    }
}
