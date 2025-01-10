package CPT;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class JFXTable {

    public static void setupTableColumns(TableView<MeleeWeapon> tableView) {
        
        TableColumn<MeleeWeapon, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<MeleeWeapon, String> attackNameCol = new TableColumn<>("Attack Name");
        attackNameCol.setCellValueFactory(new PropertyValueFactory<>("attackName"));

        TableColumn<MeleeWeapon, Double> impactCol = new TableColumn<>("Impact Damage");
        impactCol.setCellValueFactory(new PropertyValueFactory<>("impact"));

        TableColumn<MeleeWeapon, Double> punctureCol = new TableColumn<>("Puncture Damage");
        punctureCol.setCellValueFactory(new PropertyValueFactory<>("puncture"));

        TableColumn<MeleeWeapon, Double> slashCol = new TableColumn<>("Slash Damage");
        slashCol.setCellValueFactory(new PropertyValueFactory<>("slash"));

        TableColumn<MeleeWeapon, Double> baseDamageCol = new TableColumn<>("Base Damage");
        baseDamageCol.setCellValueFactory(new PropertyValueFactory<>("baseDamage"));

        TableColumn<MeleeWeapon, Double> totalDamageCol = new TableColumn<>("Total Damage");
        totalDamageCol.setCellValueFactory(new PropertyValueFactory<>("totalDamage"));

        TableColumn<MeleeWeapon, Double> critChanceCol = new TableColumn<>("Critical Hit Chance");
        critChanceCol.setCellValueFactory(new PropertyValueFactory<>("critChance"));

        TableColumn<MeleeWeapon, Double> critMultiplierCol = new TableColumn<>("Critical Hit Multiplier");
        critMultiplierCol.setCellValueFactory(new PropertyValueFactory<>("critMultiplier"));

        TableColumn<MeleeWeapon, Double> statusChanceCol = new TableColumn<>("Status Chance");
        statusChanceCol.setCellValueFactory(new PropertyValueFactory<>("statusChance"));

        TableColumn<MeleeWeapon, Double> speedCol = new TableColumn<>("Attack Speed");
        speedCol.setCellValueFactory(new PropertyValueFactory<>("speed"));

        TableColumn<MeleeWeapon, Integer> masteryCol = new TableColumn<>("Required Mastery Rank");
        masteryCol.setCellValueFactory(new PropertyValueFactory<>("mastery"));

        TableColumn<MeleeWeapon, String> introducedDateCol = new TableColumn<>("Date Introduced in Game");
        introducedDateCol.setCellValueFactory(new PropertyValueFactory<>("introducedDate"));

        TableColumn<MeleeWeapon, String> classCol = new TableColumn<>("Weapon Class");
        classCol.setCellValueFactory(new PropertyValueFactory<>("weaponClass"));

        // Add all columns to the TableView
        tableView.getColumns().addAll(nameCol, attackNameCol, impactCol, punctureCol, slashCol,
                                      baseDamageCol, totalDamageCol, critChanceCol, critMultiplierCol,
                                      statusChanceCol, speedCol, masteryCol, introducedDateCol, classCol);
    }
}
