import { useState } from 'react'

export default function CreateSession() {
	const [newName, setNewName] = useState('')

	const handleNameChange = event => {
		setNewName(event.target.value)
	}

	const handleClick = event => {
		console.log(newName)
	}
	return (
		<div className="container bg-dark text-light">
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
				<button className='btn btn-light'
						onClick={handleClick}>
					Create
				</button>
			</form>
		</div>
	)
}
