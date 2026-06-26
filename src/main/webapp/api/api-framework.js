export default class ApiFramework {
    apiRoute = "restservices/";

    constructor(apiRoute = null) {
        this.apiRoute = apiRoute ?? this.apiRoute;
    }

    async getRequest(endpoint, params = {}) {
        const response = await fetch(this.apiRoute + endpoint, {
            method: "GET",
            headers: {"content-type": "application/json"},
            ...params
        });

        if (!response.status.toString().startsWith("4") && !response.status.toString().startsWith("5")) {
            const returnedData = await response.json();
            return returnedData;
        } else {
            const message = response.message ?? "Something went wrong";
            alert("Error: " + message);
            return false;
        }
    }

    async putRequest(endpoint, params) {
        const response = await fetch(this.apiRoute + endpoint, {
            method: "PUT",
            headers: {"content-type": "application/json"},
            ...params
        });

        const returnedData = await response.json();

        if (!response.status.toString().startsWith("4") && !response.status.toString().startsWith("5")) {
            return returnedData;
        } else {
            alert("Error: " + response.message ?? "Something went wrong.");
            return false;
        }
    }
}