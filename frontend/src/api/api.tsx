import axios from 'axios'

const http = axios.create({
	baseURL: "http://localhost:9000",
	headers: {
		"Content-type": "application/json;charset=UTF-8",
		"Access-Control-Allow-Origin": "*",
	}
})

type HttpResponse = {
	isSuccessful: boolean;
	body: String;
}

type Session = {
	id: String;
	name: String;
}

type SessionResponse = {
	isSuccessful: boolean;
	body: Session;
}

type Restaurant = {
	id: String;
	sessionId: String;
	name: String;
}

type AllRestaurantsResponse = {
	isSuccessful: boolean;
	body: Restaurant[]
}

export default class DataService {
	static addSession(data:Session): HttpResponse {
		return http.post("/sessions", data)
	}

	static getSession(id:String): SessionResponse {
		return http.get(`/sessions/${id}`)
	}

	static getAllRestaurants(id:String): AllRestaurantsResponse {
		return http.get(`/restaurants/${id}`)
	}

	static addRestaurant(data:Restaurant): HttpResponse {
		return http.post("/restaurants", data)
	}
}
