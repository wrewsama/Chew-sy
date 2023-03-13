import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import randomString from 'random-string' 
import DataService from '../api/api'

export default function CreateSession() {
	const [newName, setNewName] = useState('')
	const [loading, setLoading] = useState(false)
	const sessionId:String = randomString()
	const navigate = useNavigate()

	const handleNameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
		setNewName(event.target.value)
	}

	const saveSession = () => {
		if (newName == '') {
			return
		}
		const newSession = {
			id: sessionId,
			name: newName
		}
		setLoading(true)
		DataService.addSession(newSession)
			.then(res => {
				setLoading(false)
				navigate(`/${sessionId}`)
			})
			.catch(e => {
				console.error(e)
			})
	}

	const handleClick:React.MouseEventHandler<HTMLElement> = event => {
		event.preventDefault()
		saveSession()
	}

	const handleKeyPress = (event: React.KeyboardEvent<HTMLInputElement>) => {
		if (event.code === 'Enter') {
			event.preventDefault()
			saveSession()
		}
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
						   onChange={handleNameChange}
						   onKeyDown={handleKeyPress} />
				</div>

				{
					loading ? (
						<button className='btn btn-light'
						        type='button'
								disabled>
							<span className="spinner-border spinner-border-sm"></span>
							Loading...
						</button>
					) : (
						<button type='button' 
								className='btn btn-light'
								onClick={handleClick}>
							Create
						</button>
					)
				}
				
			</form>
		</div>
	)
}
