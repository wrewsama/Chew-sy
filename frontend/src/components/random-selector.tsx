import { useState } from 'react'
import { useParams } from 'react-router-dom'
import DataService from '../api/api'

export default function RandomSelector() {
	const { id } = useParams()
	const [choice, setChoice] = useState('')

	const onGenButtonClick = event => {
		DataService.getRandomRestaurant(id)
			.then(res => {
				setChoice(res.data.body.name)
				console.log(choice)
			})
			.catch(e => {
				console.error(e)
			})
	}

	return (
		<div className='container d-flex justify-content-center'>
			{
				(choice === '') ? (
					<button className='btn btn-outline-primary'
					        onClick={onGenButtonClick}>
						Generate Random Suggestion
					</button>
				) : (
					<div className='text-center'> 
						<p className='fs-4'>
							Your suggested restaurant:
						</p>
						<h3>
							{choice}
						</h3>
						<button className='btn btn-outline-primary'
					            onClick={onGenButtonClick}>
							Generate New Suggestion	
						</button>

					</div>
				)
			}
		</div>
	)
}
