export default function Restaurant({ restaurant }) {
	return (
		<li className="list-group-item list-group-item-dark">
			{restaurant.name}
		</li>
	)
}
