~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	Projet Web "Security Challenge Day"

		"scd-web-app"

		Projet "LibertaX"
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


http://www.cllfst.tn

https://github.com/vaytess/scd-web-app


OVERVIEW:
	
	- Gestion du challenge de sécurité via un interface web avancée ( acces Web, etat de system et de reseaux )
	- Inexistance d'applicaion capable de suivre le déroulement des challenges et données des statistiques (classement, challenge par niveau).
	- Gestion de calssement en temps réel (classement totale, classement par niveau de défficultés, challenge de type CTF).

DESCRIPTION: 

	Cette application doit permettre:
		- Au challenger de valider le code du challenge qu'il a réussi.
		- D'avoir des informations très pratiques et en temps réel sur le score de chaque équipe et leur classement.
		- D'avoir un historique complet sur les validations de score
		- D'avoir un accés sécurisé à l'application (HTTPS).
		- D'avoir des codes sécurisés (HASH).

TECHNOLGIES USED:

	Java: Acces fiable au base de donnee.
	FW Extjs: Interface Web (Grille de classement, Graphes pour les statisques)
	JSON: Echange des donnees entre Java et Extjs
	Apache Tomcat: Serveur d'application accéssible via HTTPS	


INSTALLATION:




USAGE:
	Frontend:
		- L'équipe, après la réussite d'un challenge, obtient un code qu'elle le valide via un formulaire.
		- Le code est après hashé et comparé avec le hash stocké dans la BD. S'il est valide le score est incrémenté.
		- La frontend affiche également, en temps réel, le classement des équipes par :
												Score totale
												Niveau de difficultés (3 niveaux)
												CTF (Capture The Flag).

	Backend:
		- Un administrateur accéde à cette interface pour :
							Ajouter/supprimer une équipe.
							Consulter l'historique.
							Décrémenter le score d'une équipe demandant un accés internet limité.


NOTES: 

	Nothing for now.

CONTACT/HELP:

	Developer Contact:

		ahmed.bessifi@gmail.com
		manel.elarbi@gmail.com
		marwenammi@gmail.com	
		saidi.mohamed.ali.88@gmail.com	
		akaichi.akaichi.sabrine@gmail.com

	Mailing list:
	
		cllfstmembres@lists.tuxfamily.org
		cllfst@lists.tuxfamily.org

CREDITS:

	Ahmed Bessifi
	Manel Elarbi
	Marwen Ammi
	Mohamed Ali Saidi
	Sabrine Akaichi
	
