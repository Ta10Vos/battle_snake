import ApiFramework from "../api/api-framework.js";

export default class SnakeService {
    apiFramework = new ApiFramework("../restservices/");

    async getSnake() {
        return await this.apiFramework.getRequest("snake/");
    }

    async updateSnake(updatedSnake) {
        return await this.apiFramework.putRequest("snake/", {
            "body": JSON.stringify(updatedSnake)
        });
    }
}
