import { useState } from 'react'
import { Link } from 'react-router-dom'
import randomString from 'random-string' 
import DataService from '../api/api'

export default function CreateSession() {
	const [newName, setNewName] = useState('')
	const sessionId:String = randomString() 

	const handleNameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
		setNewName(event.target.value)
	}

	const handleClick:React.MouseEventHandler<HTMLElement> = event => {
		const newSession = {
			id: sessionId,
			name: newName
		}

		DataService.addSession(newSession)
			.then(res => {
				console.log(res.data)
			})
			.catch(e => {
				console.error(e)
			})
	}
	return (
		<div className="container">
			<div className="row text-center mb-5">
				<h2> Create a new Session </h2>
			</div>
			<form>	
				<div className="mb-3">
					<label className="form-label"> Your Name </label>
					<input type="text"
					       className="form-control"
						   value={newName}
						   onChange={handleNameChange} />
				</div>
				<Link to={`/${sessionId}`}> 
					<button type='button' 
							className='btn btn-light'
							onClick={handleClick}>
						Create
					</button>
				</Link>
			</form>
		</div>
	)
}
