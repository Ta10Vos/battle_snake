export default class ApiFramework {
    static apiRoute = "restservices/";
    
    static async getRequest(endpoint, params = {}) {
        const response = await fetch(apiRoute + endpoint, {
            method: "GET",
            headers: {"content-type": "application/json"},
            ...params
        });

        const returnedData = await response.json();

        if (!response.status.toString().startsWith("4") && !response.status.toString().startsWith("5")) {
            return JSON.parse(returnedData);
        } else {
            alert("Error: " + response.message ?? "Something went wrong.");
            return false;
        }
    }

    static async putRequest(endpoint, params) {
        const response = await fetch(apiRoute + endpoint, {
            method: "PUT",
            headers: {"content-type": "application/json"},
            ...params
        });

        const returnedData = await response.json();

        if (!response.status.toString().startsWith("4") && !response.status.toString().startsWith("5")) {
            return JSON.parse(returnedData);
        } else {
            alert("Error: " + response.message ?? "Something went wrong.");
            return false;
        }
    }
}