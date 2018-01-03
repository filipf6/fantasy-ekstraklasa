import {Pipe, PipeTransform} from "@angular/core";
import {TeamPlayer} from "../../models/team-player.model";

@Pipe({ name: 'positionFilter' })
export class PlayerPositionFilterPipe implements PipeTransform {
  transform(allPlayers: TeamPlayer[], position: string, firstSquad: boolean) {
    // allPlayers.forEach(p=>{
    //   console.log(p.player.name+'->'+p.firstSquad+'=?'+firstSquad);
    // });
    return allPlayers.filter(player=>player.firstSquad===firstSquad && player.player.position===position);
  }
}
