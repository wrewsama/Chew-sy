import { useState } from 'react'
import DataService from '../api/api'

export default function Restaurant({ restaurant, callback }) {
	const [deleteButtonStyle, setDeleteButtonStyle] = useState({ display: 'none' })
	const [itemClass, setItemClass] = useState('')

	const handleMouseEnter = event => {
		setDeleteButtonStyle({ display: 'block' })
		setItemClass('list-group-item-primary')
	}

	const handleMouseLeave = event => {
		setDeleteButtonStyle({ display: 'none' })
		setItemClass('')
	}

	const handleDeleteButtonClick = event => {
		DataService.deleteRestaurant(restaurant.id)
			.then(res => {
				callback()
			})
			.catch(e => {
				console.error(e)
			})
	}

	return (
		<li className={`list-group-item d-flex ${itemClass}`}
		    onMouseEnter={handleMouseEnter}
			onMouseLeave={handleMouseLeave}>
			{restaurant.name}

			<button type='button'
					style={deleteButtonStyle}
			        className='btn-close ms-auto'
					onClick={handleDeleteButtonClick} />
		</li>
	)
}
