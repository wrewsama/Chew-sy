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

export default class DataService {
	static addSession(data:Session): HttpResponse {
		return http.post("/sessions", data)
	}
}
